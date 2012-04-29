package com.fancyworld;

import static java.lang.Math.max;

public class Parser {

    public static final String WORD_OF = " of ";
    public static final String WORD_IMPORTED = " imported ";
    public static final String WORD_AT = " at ";

    public int parseCountFrom(String description) {
        return Integer.parseInt(description.split("\\s")[0]);
    }

    public String parseNameFrom(String description) {
        int startIndex = nameStartIndex(description);
        int endIndex = nameEndIndex(description);

        return description.substring(startIndex,endIndex).trim();
    }

    public double parsePriceFrom(String description) {
        String[] descriptionToken = description.split("\\s");
        return Double.parseDouble(descriptionToken[descriptionToken.length-1]);
    }

    public Type parseTypeFrom(String description) {
        boolean isImported = description.contains(WORD_IMPORTED);
        return (isImported ? Type.IMPORTED : Type.LOCAL);
    }

    private int leftIndex(String string, String subString){
        return string.indexOf(subString);
    }

    private int rightIndex(String string, String subString){
        int index = string.indexOf(subString);
        return index == -1 ? -1 : (index + subString.length() - 1);
    }

    private int nameEndIndex(String description) {
        return leftIndex(description, WORD_AT);
    }

    private int nameStartIndex(String description) {
        int startIndex;
        int ofRightIndex = rightIndex(description, WORD_OF);
        int importRightIndex = rightIndex(description, WORD_IMPORTED);
        if(ofRightIndex == -1){
            if(importRightIndex == -1){
                startIndex = rightIndex(description, " ");
            } else {
                startIndex = importRightIndex;
            }
        } else {
            if(importRightIndex == -1){
                startIndex = ofRightIndex;
            } else {
                startIndex = max(ofRightIndex,importRightIndex);
            }
        }
        return startIndex;
    }

    private String fixImportedPosition(String description) {
        String[] tokens = description.split("\\s");
        if(description.contains("imported") && !tokens[1].equals("imported")){
            description = description.replace(" imported "," ");
            description = description.replaceFirst(" "," imported ");
        }
        return description;
    }

    public String transDescription(String description){
        description = fixImportedPosition(description);
        return description.substring(0, description.indexOf(" at "));
    }
}
