package msgs;

import com.google.common.primitives.Ints;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import msgs.IMessageService;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class CustomMessage implements IMessageService{
    private int amount;

    @NonNull
    private String prefix;

    @NonNull
    private String delimiter;

    @NonNull
    private String message;

    @Override
    public String getMessage() {
        return IntStream.range(0, amount).mapToObj(cnt -> "" + cnt + prefix + delimiter + message).collect(Collectors.joining(""));
    }
}
