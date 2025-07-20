package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

public class RobustnessTesting {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @ParameterizedTest
    @CsvSource({
        "50000, 15, -1, Standard",
        "50000, 15, 0, Standard",
        "50000, 15, 1, Standard",
        "50000, 15, 500, Gold",
        "50000, 15, 999, Gold",
        "50000, 15, 1000, Gold",
        "50000, 15, 1001, Standard",
        "50000, -1, 500, Standard",
        "50000, 0, 500, Standard",
        "50000, 1, 500, Silver",
        "50000, 29, 500, Gold",
        "50000, 30, 500, Gold",
        "50000, 31, 500, Gold",
        "-1, 15, 500, Standard",
        "0, 15, 500, Standard",
        "1, 15, 500, Standard",
        "99999, 15, 500, Gold",
        "100000, 15, 500, Gold",
        "100001, 15, 500, Standard"
    })
    void testMembershipRank_Robustness(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
        String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expectedResult, result);
    }
}