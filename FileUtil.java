package com.example.utils;

import com.example.constant.MessageConstant;
import com.example.exception.FileDirectoryDeleteExection;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


@Slf4j
public class FileUtil {
    public static void deleteFiles(String filePath, String fileNameToDelete) {
        log.info("开始执行删除数据逻辑");
        try {
            Path dir = Paths.get(filePath);
            Files.walk(dir).filter(path -> path.toFile().isFile()).filter(path -> path.getFileName().toString().equals(fileNameToDelete)).forEach(path -> {
                try {
                    Files.delete(path);
                    log.info("删除文件成功目录：{}, 文件地址：{}", dir, fileNameToDelete);
                } catch (IOException e) {
                    log.error("删除文件失败目录：{},文件地址：{}", dir, fileNameToDelete);
                    log.error("{}   {}", e.getClass(), e.getMessage());
                }
            });
        } catch (IOException e) {
            log.error("删除文件异常：{}", e.getMessage());
        }
    }

    public static void deleteFile(String fileLocal) {
        log.info("开始执行删除数据逻辑...");
        Path filePath = Paths.get(fileLocal); // 替换为你要删除的文件路径

        try {
            if (Files.deleteIfExists(filePath)) {
                log.info("文件 {} 删除成功", filePath);
            } else {
                log.error("文件 {} 不存在，删除操作未执行", filePath);
            }
        } catch (IOException e) {
            log.error("无法删除文件: " + e.getMessage());
        }
    }


    public static void delete(String fileLocal) {
        Path dir = Paths.get(fileLocal);
        if (Files.exists(dir)) {
            try {
                Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        log.info("已删除--- {}",file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        log.info("已删除--- {}",dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                log.error("{}  {}  ",e.getClass(),e.getMessage());
            }
        }
    }


    /**
     * 拷贝文件到指定目录
     *
     * @param sourceFile      源文件
     * @param targetDirectory 目标目录
     */
    public static void copyFile(String sourceFile, String targetDirectory) {
        // 源文件路径
        Path sourcePath = Paths.get(sourceFile);
        // 目标目录路径
        Path targetDirPath = Paths.get(targetDirectory);
        // 目标文件名

        String targetFileName = "file_copy.txt";
        // 目标文件路径
        Path targetPath = targetDirPath.resolve(targetFileName);
        try {
            // 复制文件
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件复制成功！");
        } catch (IOException e) {
            System.out.println("文件复制失败: " + e.getMessage());
        }
    }


    /**
     * 拷贝文件,支持改名
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件  可支持改名
     */
    public static void copyFileAndRename(String sourceFile, String targetFile) {
        Path source = Paths.get(sourceFile);
        Path target = Paths.get(targetFile);
        try {
            Files.copy(source, target);
            log.info("文件 {}  拷贝成功至 {} ！", source, target);
        } catch (IOException e) {
            log.error("文件 {}  拷贝失败! ", source);
            log.error("{}  {}", e.getClass(), e.getMessage());
        }
    }

    /**
     * 拷贝文件,支持改名,  目标文件已存在时进行覆盖
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件  可支持改名
     */
    public static void copyFileAndCover(String sourceFile, String targetFile) {
        Path source = Paths.get(sourceFile);
        Path target = Paths.get(targetFile);
        try {
            // 拷贝文件，如果目标文件已存在，会抛 FileAlreadyExistsException
            //  如果希望在目标文件已存在时进行覆盖，可以使用 StandardCopyOption.REPLACE_EXISTING：
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);// 覆盖已有文件
            log.info("文件 {}  拷贝成功至 {} ！", source, target);
        } catch (IOException e) {
            log.error("文件 {}  拷贝失败!  {}", source, e.getMessage());
            e.printStackTrace();
        }
    }
}
