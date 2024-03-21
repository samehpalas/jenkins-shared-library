#! /usr/bin/env groovy

import com.example.Docker //call functions of scr

def call(String imgName) {
    return new Docker(this).dockerbuild (imgName)
}
