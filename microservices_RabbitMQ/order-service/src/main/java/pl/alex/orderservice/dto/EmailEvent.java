package pl.alex.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailEvent {
    private String id;
    private String from;
    private String to;
    private String message;
}
