package com.my.xxtbackgroud.controller;


import com.my.xxtbackgroud.pojo.userBean;
import com.my.xxtbackgroud.service.UserService;
import com.my.xxtbackgroud.utils.MedioHttpRequestHandler;
import com.my.xxtbackgroud.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {



    @Resource
    private MedioHttpRequestHandler medioHttpRequestHandler;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("{stuid}/{password}")
    public Result LoginCheck(@PathVariable String stuid, @PathVariable String password) {
        userBean user = userService.login(stuid);

        if (user != null) {
            log.info(user + "");
            if (user.getPassWord().equals(password)) {
                return new Result(true, user);
            } else {
                return new Result("密码错误");
            }

        } else {

            return new Result("账号未注册");
        }

    }

    @GetMapping(value = "video", produces = "application/json;charset=utf-8")
    public void aloneVideoPlay(HttpServletResponse response) throws IOException {
        InputStream is;
        OutputStream os;
        response.setContentType("video/mp4");
        File file = new File("D:\\阿里云盘\\test.mp4");
        response.addHeader("Content-Length", "" + file.length());
        is = Files.newInputStream(file.toPath());
        os = response.getOutputStream();
        IOUtils.copy(is, os);
        os.close();
        log.info("被请求一次");
    }

    @GetMapping("shiPing")
    public void VideoPlay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "D:\\阿里云盘\\活着.mp4";
        Path path = Paths.get(url);
        if (Files.exists(path)) {
            String mimeType = Files.probeContentType(path);
            if (!StringUtils.hasText(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(MedioHttpRequestHandler.ATTR_FILE, path);
            medioHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

}
