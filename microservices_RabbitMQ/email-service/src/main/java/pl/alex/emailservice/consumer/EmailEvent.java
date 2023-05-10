package pl.alex.emailservice.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailEvent {
    private String from;
    private String to;
    private String message;
}
