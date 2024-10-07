package com.example.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.exception.SVNCheckoutExection;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * SVNManager SVN管理器
 */
public class SVNManager {
    private String url;
    private String username;
    private String password;
    private SVNRepository repository;

    public SVNManager(String url, String username, String password) {
        super();
        this.url = url;
        this.username = username;
        this.password = password;
        initialize();
    }

    /**
     * 初始化操作
     *
     * @throws SVNException
     */
    private void initialize() {
        FSRepositoryFactory.setup();
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        try {
            repository = SVNRepositoryFactoryImpl.create(SVNURL.parseURIEncoded(this.url));
            ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(this.username, this.password);
            repository.setAuthenticationManager(authManager);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从SVN服务器获取最新版本的文件
     *
     * @param filePath    相对于仓库根目录的路径
     * @param outFileName 要输出的目标流，可以是文件流 FileOutputStream
     * @return 返回checkout文件的版本号
     * @throws Exception 可以自定义Exception
     */
    public long getFileFromSVN(String filePath, String outFileName) throws SVNCheckoutExection {
        return getFileFromSVN(filePath, outFileName, 0);
    }

    /**
     * 从SVN服务器获取文件
     *
     * @param filePath    相对于仓库根目录的路径
     * @param outFileName 要输出的目标流，可以是文件流 FileOutputStream
     * @param version     要checkout的版本号，当传入的版本号为0时，默认获取最新版本
     * @return 返回checkout文件的版本号
     * @throws Exception 可以自定义Exception
     */
    public long getFileFromSVN(String filePath, String outFileName, long version) throws SVNCheckoutExection {
        SVNNodeKind node = null;
        try {
            if (version == 0) {
                version = repository.getLatestRevision();
            }
            node = repository.checkPath(filePath, version);
        } catch (SVNException e) {
            throw new SVNCheckoutExection("SVN检测不到该文件:" + filePath + e.getMessage());
        }
        if (node != SVNNodeKind.FILE) {
            throw new SVNCheckoutExection(node.toString() + "不是文件");
        }
        SVNProperties properties = new SVNProperties();
        try {
            OutputStream outputStream = new FileOutputStream(outFileName);
            repository.getFile(filePath, version, properties, outputStream);
            outputStream.close();
        } catch (SVNException e) {
            throw new SVNCheckoutExection("获取SVN服务器中的" + filePath + "文件失败    " + e.getMessage());
        } catch (IOException e) {
            throw new SVNCheckoutExection("SVN check out file faild.  " + e.getMessage());
        }
        return Long.parseLong(properties.getStringValue("svn:entry:revision"));
    }

    /**
     * 获取目录下的所有文件和子目录
     *
     * @param res 包含目录参数的资源对象.参加{ @link  Resource#getPath()}
     * @return 资源列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Resource> getChildren(Resource res) throws Exception {
        String path = res.getPath();
        Collection<SVNDirEntry> entries;
        try {
            entries = repository.getDir(path, -1, null, (Collection) null);
        } catch (SVNException e) {
            throw new Exception("获得" + path + "下级目录失败", e);
        }
        List<Resource> result = new ArrayList<Resource>();
        for (SVNDirEntry entry : entries) {
            if (containsSpecialFile(entry)) {
                Resource resource = new Resource();
                resource.setName(entry.getName());
                resource.setPath(entry.getURL().getPath());
                resource.setFile(entry.getKind() == SVNNodeKind.FILE);
                result.add(resource);
            }
        }
        return result;
    }

    /**
     * 判断文件是否存在
     *
     * @param entry 要判断的节点.参加{ @link  SVNDirEntry}
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private boolean containsSpecialFile(SVNDirEntry entry) throws Exception {
        if (entry.getKind() == SVNNodeKind.FILE) {
            return true;
        } else if (entry.getKind() == SVNNodeKind.DIR) {
            Collection<SVNDirEntry> entries;
            String path = entry.getURL().getPath();
            try {
                entries = repository.getDir(path, -1, null, (Collection) null);
            } catch (SVNException e) {
                throw new Exception("获得" + path + "下级目录失败", e);
            }
            for (SVNDirEntry unit : entries) {
                if (containsSpecialFile(unit)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        SVNManager manager = new SVNManager("svn://gitee.com/limeiyu01/svn-test", "13384999825", "li13992677246");
        try {
            System.out.println(manager.getFileFromSVN("/log工具/p/9.xlsx", property+"\\"+physicalVersion+"\\Test\\TestDoc\\p11x.xlsx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void testGetDir() {
//        try {
//            initialize();
//            Resource res = new Resource();
//            res.setPath("/app1/");
//            List<Resource> rs = getChildren(res);
//            for(Resource r : rs) {
//                System.out.println(r.getFile()?"file:":"directory:" + r.getPath());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

/**
 * 资源对象
 */
class Resource {
    /**
     * 相对仓库根目录的路径
     */
    private String path;
    /**
     * 文件/文件夹的名称
     */
    private String name;
    /**
     * 是否是文件 文件：true | 文件夹：false
     */
    private boolean isFile;
    /**
     * 版本号
     */
    private long SVNVersion;
    /**
     * 本地路径
     */
    private String localPath;

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public long getSVNVersion() {
        return SVNVersion;
    }

    public void setSVNVersion(long sVNVersion) {
        SVNVersion = sVNVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFile() {
        return isFile;
    }

    public void setFile(boolean isFile) {
        this.isFile = isFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
