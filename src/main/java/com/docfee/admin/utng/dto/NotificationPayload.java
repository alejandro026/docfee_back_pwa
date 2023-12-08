package com.docfee.admin.utng.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationPayload {

    private Notification notification;

    // Constructor, getters y setters
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Notification {

        private String title;
        private String body;
        private int[] vibrate;
        private String image;
        private Action[] actions;

        // Constructor, getters y setters
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Action {

            private String action;
            private String title;

            // Constructor, getters y setters
        }
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}