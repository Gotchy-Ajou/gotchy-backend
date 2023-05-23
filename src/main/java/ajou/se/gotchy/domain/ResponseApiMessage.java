package ajou.se.gotchy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseApiMessage {
    int httpStatus;
    String message;
    Object responseDate;

    @Builder
    public ResponseApiMessage(int httpStatus, String message, Object responseDate){
        this.httpStatus = httpStatus;
        this.message = message;
        this.responseDate = responseDate;
    }
}
