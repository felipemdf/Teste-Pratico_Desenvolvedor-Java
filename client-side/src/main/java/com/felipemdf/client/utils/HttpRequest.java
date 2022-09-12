/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CarDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequest<T> {

    ObjectMapper objectMapper;
    ObjectWriter objectWriter;
    Gson gson;

    public HttpRequest(String baseUrl) {
        this.objectMapper = new ObjectMapper();
        this.objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        
        this.gson = new Gson();
    }

    public ResponseDto save(String url, Object dto) throws UnsupportedEncodingException, IOException {
        HttpPost request = new HttpPost(url);
        String json = gson.toJson(dto);
        request.setEntity(new StringEntity(json));
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        try (
                 CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(request)) {
            return Utils.getResponseDto(response);
        }
    }

    public ResponseDto update(String url, Long id, Object dto) throws UnsupportedEncodingException, IOException {
        HttpPatch request = new HttpPatch(url + "/" + id);
        String json = gson.toJson(dto);
        request.setEntity(new StringEntity(json));
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        try (
                 CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(request)) {
            return Utils.getResponseDto(response);
        }
    }

    public ResponseDto delete(String url, Long id) throws UnsupportedEncodingException, IOException {
        HttpDelete request = new HttpDelete(url + "/" + id);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        try (
                 CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(request)) {
            return Utils.getResponseDto(response);
        }
    }

    public ArrayList<T> get(String url, TypeToken typeToken, HashMap<String, String> filters) throws UnsupportedEncodingException, IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(url + "/search");
        filters.forEach((key, value) -> {
            builder.setParameter(key, value);
        });

        HttpGet request = new HttpGet(builder.build());
        try (
                 CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            return gson.fromJson(json, typeToken.getType()); 
        }
    }

    public <T> ArrayList getAll(String url, TypeToken typeToken) throws UnsupportedEncodingException, IOException {
        HttpGet request = new HttpGet(url);

        try (
                 CloseableHttpClient httpClient = HttpClients.createDefault();  CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.print(json);
            return gson.fromJson(json, typeToken.getType()); 
        }
    }
}
