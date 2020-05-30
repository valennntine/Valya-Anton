package main.resources;

public class InstanceCheck {
    public int countChars(String str, char c) {
        int counter = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isDouble(String str) {
        if (this.countChars(str, '.') == 1) {
            int pointIndex = str.indexOf('.');
            String whole = str.substring(0, pointIndex);
            String mantis = str.substring(pointIndex + 1);

            return this.isInt(whole) && this.isInt(mantis);
        }
        return false;
    }

    public boolean isString(String str) {
        return str.length() > 1 && !(this.isInt(str) || this.isDouble(str));
    }

    public boolean isChar(String str) {
        return str.length() == 1 && !this.isInt(str);
    }

    public String getType(String str) {
        if(this.isInt(str)) {
            return "int";
        }
        if(this.isDouble(str)) {
            return "double";
        }
        if(this.isChar(str)) {
            return "char";
        }
        if(this.isString(str)) {
            return "string";
        }
        return "unknown";
    }
}
