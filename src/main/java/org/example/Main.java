package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.example.service.PostReaderService;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        PostReaderService postReaderService = PostReaderService.instance();
        postReaderService.addPostFromJsonFile("src/main/resources/post.json");

        Tomcat tomcat = new Tomcat();
        tomcat.enableNaming();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String ctxPath = "/AnonBook";
        String webappDir = new File("src/main/webapp").getAbsolutePath();
        StandardContext ctx = (StandardContext) tomcat.addWebapp(ctxPath, webappDir);

        File additionWebInfClasses = new File("build/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
