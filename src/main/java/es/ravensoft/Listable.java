package es.ravensoft;

import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
public class Listable {

    private final Integer id;
    private final String code;
    private final String desc;

    public Listable(Integer id) {
        this.id = id;
        this.code = RandomStringUtils.random(50, true, true);
        this.desc = RandomStringUtils.random(255, true, true);
    }

    public boolean isEven() {
        return this.id % 2 == 0;
    }

}
