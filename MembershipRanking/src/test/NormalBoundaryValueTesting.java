package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

public class NormalBoundaryValueTesting {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    @ParameterizedTest
    @CsvSource({
    	"50000, 15, 0, Standard",
        "50000, 15, 1, Standard",
        "50000, 15, 500, Silver",
        "50000, 15, 999, Gold",
        "50000, 15, 1000, Gold",
        "50000, 0, 500, Standard",
        "50000, 1, 500, Silver",
        "50000, 29, 500, Silver",
        "50000, 30, 500, Silver",
        "0, 15, 500, Standard",
        "1, 15, 500, Standard",
        "9999, 15, 500, Gold",
        "10000, 15, 500, Gold",
    })
    void testMembershipRank(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
        String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expectedResult, result);
    }
}