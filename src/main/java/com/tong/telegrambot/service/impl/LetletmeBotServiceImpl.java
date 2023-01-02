package com.tong.telegrambot.service.impl;

import com.tong.telegrambot.constant.Constant;
import com.tong.telegrambot.service.ILetletmeBotService;
import com.tong.telegrambot.utils.JsonUtils;
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

/**
 * Create by tong on 2023/1/2
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetletmeBotServiceImpl implements ILetletmeBotService {

    private final InterfaceServiceImpl interfaceService;

    @Override
    public String priceChange() {
        StringBuilder builder = new StringBuilder();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.SHORTDAY));
        this.interfaceService.qryPlayerValueByDate(date).ifPresent(result -> {
            String rise = "Rise";
            String faller = "Faller";
            Map<String, List<LinkedHashMap<String, Object>>> map = JsonUtils.json2obj(result, Map.class);
            if (CollectionUtils.isEmpty(map)) {
                return;
            }
            // rise
            builder.append("Rise:").append("\r\n");
            if (!map.containsKey(rise) || CollectionUtils.isEmpty(map.get(rise))) {
                builder.append("None").append("\r\n");
            } else {
                map.get(rise).forEach(o ->
                        builder.append(o.get("webName"))
                                .append("[").append(o.get("teamShortName")).append("]")
                                .append("  ")
                                .append(o.get("lastValue")).append("m").append(" => ").append(o.get("value")).append("m")
                                .append("\r\n")
                );
            }
            builder.append("\r\n");
            // fall
            builder.append("Faller:").append("\r\n");
            if (!map.containsKey(faller) || CollectionUtils.isEmpty(map.get(faller))) {
                builder.append("None").append("\r\n");
            } else {
                map.get(faller).forEach(o ->
                        builder.append(o.get("webName"))
                                .append("[").append(o.get("teamShortName")).append("]")
                                .append("  ")
                                .append(o.get("lastValue")).append("m").append(" => ").append(o.get("value")).append("m")
                                .append("\r\n")
                );
            }
        });
        return builder.toString();
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
            LocalDateTime localDateTime = LocalDateTime.now();
            String utcDeadline = map.get("utcDeadline");
            // London
            String londonZone = "GMT+0";
            ZoneId londonZoneId = ZoneId.of(londonZone);
            String londonDeadline = LocalDateTime.ofInstant(Instant.parse(utcDeadline), londonZoneId).atZone(londonZoneId).format(DateTimeFormatter.ofPattern(Constant.DATETIME));
            LocalDateTime londonDateTime = LocalDateTime.parse(londonDeadline, DateTimeFormatter.ofPattern(Constant.DATETIME));
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

}
