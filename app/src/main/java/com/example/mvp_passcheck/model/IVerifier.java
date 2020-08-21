package com.example.mvp_passcheck.model;

public interface IVerifier {

    boolean evaluateLength(String password);
    boolean evaluateUpper(String password);

}