package com.accenture.davydenko.model.entity;

public enum Access {
    READ, WRITE, DELETE, FULL, READ_AND_WRITE,NO_ACCESS,ADMIN,TENANT
    //возможно стоит убрать чтобы заменить на связь с бд
}
