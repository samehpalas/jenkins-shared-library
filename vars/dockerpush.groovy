#! /usr/bin/env groovy

import com.example.Docker

def call(String imgName) {
    return new Docker(this).buildpush (imgName)
}