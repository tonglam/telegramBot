package com.tong.telegramBot.service.impl;

import com.tong.telegramBot.constant.Constant;
import com.tong.telegramBot.service.ILetletmeBotCommandService;
import com.tong.telegramBot.utils.CommonUtils;
import com.tong.telegramBot.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Create by tong on 2023/1/2
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetletmeBotCommandServiceImpl implements ILetletmeBotCommandService {

    private final InterfaceServiceImpl interfaceService;

    @Override
    public String priceChange() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.SHORTDAY));
        Optional<String> result = this.interfaceService.qryPlayerValueByDate(date);
        return result.map(CommonUtils::initPlayerValueData).orElse("");
    }

    @Override
    public String ddl() {
        StringBuilder builder = new StringBuilder();
        this.interfaceService.qryCurrentEventAndNextUtcDeadline().ifPresent(result -> {
            Map<String, String> map = JsonUtils.json2obj(result, Map.class);
            if (CollectionUtils.isEmpty(map)) {
                return;
            }
            // event
            String event = map.get("event");
            builder.append("Gameweek ").append(event).append(" Deadline: ").append("\r\n").append("\r\n");
            // deadline
            String utcDeadline = map.get("utcDeadline");
            // London
            String londonZone = "GMT+0";
            ZoneId londonZoneId = ZoneId.of(londonZone);
            String londonDeadline = LocalDateTime.ofInstant(Instant.parse(utcDeadline), londonZoneId).atZone(londonZoneId).format(DateTimeFormatter.ofPattern(Constant.DATETIME));
            builder
                    .append("London")
                    .append("         ")
                    .append(londonDeadline)
                    .append(" (").append(londonZone).append(")")
                    .append("\r\n");
            // China
            String guangzhouZone = "GMT+8";
            ZoneId guangzhouZoneId = ZoneId.of(guangzhouZone);
            String guangzhouDeadline = LocalDateTime.ofInstant(Instant.parse(utcDeadline), guangzhouZoneId).atZone(guangzhouZoneId).format(DateTimeFormatter.ofPattern(Constant.DATETIME));
            builder
                    .append("Guangzhou")
                    .append("  ")
                    .append(guangzhouDeadline)
                    .append(" (").append(guangzhouZone).append(")")
                    .append("\r\n");
            // Japan
            String tokyoZone = "GMT+9";
            ZoneId tokyoZoneId = ZoneId.of(tokyoZone);
            String tokyoDeadline = LocalDateTime.ofInstant(Instant.parse(utcDeadline), tokyoZoneId).atZone(tokyoZoneId).format(DateTimeFormatter.ofPattern(Constant.DATETIME));
            builder
                    .append("Tokyo")
                    .append("            ")
                    .append(tokyoDeadline)
                    .append(" (").append(tokyoZone).append(")")
                    .append("\r\n");
            // Australia
            String sydneyZone = "GMT+11";
            ZoneId sydneyZoneId = ZoneId.of(sydneyZone);
            String sydneyDeadline = LocalDateTime.ofInstant(Instant.parse(utcDeadline), sydneyZoneId).atZone(sydneyZoneId).format(DateTimeFormatter.ofPattern(Constant.DATETIME));
            builder
                    .append("Sydney")
                    .append("          ")
                    .append(sydneyDeadline)
                    .append(" (").append(sydneyZone).append(")")
                    .append("\r\n");
        });
        return builder.toString();
    }

    @Override
    public int live() {
        return 0;
    }

}
