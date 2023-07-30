public class ConcretePasswordStrengthEstimator extends PasswordStrengthEstimator {
    private static final int CHARACTER_SET_SIZE = 95;
    private static final double COMBINATIONS_PER_SECOND = 1e9;
    @Override
    public int estimateCrackTime(String password) {
        int passwordLength = password.length();
        double combinations = Math.pow(CHARACTER_SET_SIZE, passwordLength);
        double secondsToCrack = combinations / COMBINATIONS_PER_SECOND;
        return (int) secondsToCrack;
    }
}

