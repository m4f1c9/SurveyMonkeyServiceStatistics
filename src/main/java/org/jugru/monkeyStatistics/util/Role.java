package org.jugru.monkeyStatistics.util;

public class Role {

    private final static String ANNOTATION = "annotation";
    private final static String TOOLTIP = "tooltip";
    private final static String ANNOTATION_TEXT = "annotationText";

    private final static Role TOOLTIP_ROLE = new Role(TOOLTIP);
    private final static Role ANNOTATION_ROLE = new Role(ANNOTATION);
    private final static Role ANNOTATION_TEXT_ROLE = new Role(ANNOTATION_TEXT);

    private final String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Role getTooltipRole() {
        return TOOLTIP_ROLE;
    }
    
    public static Role getAnnotationRole() {
        return ANNOTATION_ROLE;
    }
    public static Role getAnnotationTextRole() {
        return ANNOTATION_TEXT_ROLE;
    }

}
