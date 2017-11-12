package org.jugru.monkeyStatistics.util;

public class Role {

    private final static String TOOLTIP = "tooltip";
    private final String role;
    private final static Role TOOLTIP_ROLE = new Role(TOOLTIP);

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Role getTooltipRole() {
        return TOOLTIP_ROLE;
    }

}
