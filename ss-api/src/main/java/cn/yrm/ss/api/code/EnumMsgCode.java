package cn.yrm.ss.api.code;

public enum EnumMsgCode {

    /** 错误的API版本号，或者此版本已不被支持 **/
    ECOM0001("0001"),
    /** 未知的服务器错误 **/
    ECOM0002("0002"),
    /** 用户不存在 **/
    ECOM0003("0003"),
    /** 用户名或者密码错误 **/
    ECOM0004("0004"),
    /** 待更新数据已被删除 */
    ECOM0005("0005"),
    /** 数据写入失败 */
    ECOM0006("0006"),
    /** 用户名{0}已存在 */
    ECOM0007("0007");

    private String value;

    private EnumMsgCode(String value) {
        this.value = value;
    }

    public String stringValue() {
        return this.value;
    }

    public static EnumMsgCode toEnumValue(String value) {
        for (EnumMsgCode d : values()) {
            if (d.stringValue().equals(value)) {
                return d;
            }
        }
        throw new IllegalArgumentException("枚举类型转换错误:" + value);
    }

    public static boolean codeOf(String value) {
        for (EnumMsgCode d : values()) {
            if (d.stringValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
