package cn.yrm.ss.api.code;

public enum EnumServiceList {


    USER_SERVICE("user"),
    STATION_SERVICE("station");

    private String value;

    private EnumServiceList(String value) {
        this.value = value;
    }

    public String stringValue() {
        return this.value;
    }

    public static EnumServiceList toEnumValue(String value) {
        for (EnumServiceList d : values()) {
            if (d.stringValue().equals(value)) {
                return d;
            }
        }
        throw new IllegalArgumentException("枚举类型转换错误:" + value);
    }

    public static boolean codeOf(String value) {
        for (EnumServiceList d : values()) {
            if (d.stringValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

}
