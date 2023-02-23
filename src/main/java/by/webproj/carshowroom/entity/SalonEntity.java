package by.webproj.carshowroom.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class SalonEntity {
    private final Long id;
    private final String salonName;
    private final double salonWeight;

    private SalonEntity(Builder builder) {
        id = builder.id;
        salonName = builder.suspensionName;
        salonWeight = builder.suspensionWeight;
    }

    public static class Builder {
        private Long id;
        private String suspensionName;
        private double suspensionWeight;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String engineName) {
            this.suspensionName = engineName;
            return this;
        }

        public Builder withWeight(double engineWeight) {
            this.suspensionWeight = engineWeight;
            return this;
        }

        public SalonEntity build() {
            return new SalonEntity(this);
        }
    }
}
