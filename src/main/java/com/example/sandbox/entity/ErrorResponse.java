package com.example.sandbox.entity;

public class ErrorResponse
{
    private String code;
    private String 메세지;
    
    public ErrorResponse()
    {
        super();
    }
    public ErrorResponse(String code, String 메세지)
    {
        super();
        this.code = code;
        this.메세지 = 메세지;
    }
    
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String get메세지()
    {
        return 메세지;
    }
    public void set메세지(String 메세지)
    {
        this.메세지 = 메세지;
    }
    @Override
    public String toString()
    {
        return "ErrorResponse [code=" + code + ", 메세지=" + 메세지 + "]";
    }
}