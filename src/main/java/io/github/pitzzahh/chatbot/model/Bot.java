package io.github.pitzzahh.chatbot.model;

import lombok.*;

import java.util.Map;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Bot {
    private String name;
    private Map<String, String> responses;
}
