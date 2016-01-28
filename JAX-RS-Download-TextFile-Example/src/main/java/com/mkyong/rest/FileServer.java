package com.mkyong.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/file")
public class FileServer
{
    @GET
    @Path("/text/{fileName}")
    @Produces("text/plain")
    public Response getFileInTextFormat(@PathParam("fileName") String fileName)
    {
        System.out.println("File requested is : " + fileName);
         
        //Put some validations here such as invalid file name or missing file name
        if(fileName == null || fileName.isEmpty())
        {
            ResponseBuilder response = Response.status(Status.BAD_REQUEST);
            return response.build();
        }
         
        //Prepare a file object with file to return
        File file = new File("d://uploaded/IDS.txt");
         
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"howtodoinjava.txt\"");
        return response.build();
    }
     
    @GET
    @Path("/pdf/{fileName}")
    @Produces("application/pdf")
    public Response getFileInPDFFormat(@PathParam("fileName") String fileName)
    {
        System.out.println("File requested is : " + fileName);
         
        //Put some validations here such as invalid file name or missing file name
        if(fileName == null || fileName.isEmpty())
        {
            ResponseBuilder response = Response.status(Status.BAD_REQUEST);
            return response.build();
        }
         
        //Prepare a file object with file to return
        File file = new File("c:/demoPDFFile.pdf");
         
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"howtodoinjava.pdf\"");
        return response.build();
    }
     
    @GET
    @Path("/image/{fileName}")
    @Produces("image/jpeg")
    public Response getFileInJPEGFormat(@PathParam("fileName") String fileName)
    {
        System.out.println("File requested is : " + fileName);
         
        //Put some validations here such as invalid file name or missing file name
        if(fileName == null || fileName.isEmpty())
        {
            ResponseBuilder response = Response.status(Status.BAD_REQUEST);
            return response.build();
        }
         
        //Prepare a file object with file to return
        File file = new File("c:/demoJpegFile.jpeg");
         
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"howtodoinjava.jpeg\"");
        return response.build();
    }
}