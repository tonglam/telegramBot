package com.tong.telegrambot.service;

import java.util.Optional;

/**
 * Create by tong on 2023/1/2
 */
public interface IInterfaceService {

    Optional<String> qryPlayerValueByDate(String date);

    Optional<String> qryCurrentEventAndNextUtcDeadline();

}
