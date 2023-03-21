package model.game.transportation;

public enum TransportationType {
    TAXI(1),
    BUS(2),
    SUBWAY(3);

    private final int typeValue;

    TransportationType(int typeValue) {
        this.typeValue = typeValue;
    }

    public int getTypeValue() {
        return typeValue;
    }
}
