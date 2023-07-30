public abstract class PasswordStrengthEstimator {

    public abstract int estimateCrackTime(String password);

    public String formatTime(int seconds) {
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int years = days / 365;

        if (years >= 1) {
            return years + " years";
        } else if (days >= 1) {
            return days + " days";
        } else if (hours >= 1) {
            return hours + " hours";
        } else if (minutes >= 1) {
            return minutes + " minutes";
        } else {
            return seconds + " seconds";
        }
    }
}
