/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author giovanacgois
 */
@RestController
public class HelloResource {

    @RequestMapping(value = "/")
    public String hello() {
        return "DevCase - Giovana Gois";
    }
}
