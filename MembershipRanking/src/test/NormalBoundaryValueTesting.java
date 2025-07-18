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
        "50000, 3, 0, Standard",
        "50000, 3, 1, Standard",
        "50000, 3, 500, Gold",
        "50000, 3, 999, Gold",
        "50000, 3, 1000, Gold",
        "50000, 0, 500, Standard",
        "50000, 1, 500, Silver",
        "50000, 6, 500, Standard",
        "50000, 7, 500, Standard",
        "0, 3, 500, Standard",
        "1, 3, 500, Standard",
        "99999, 3, 500, Gold",
        "100000, 3, 500, Gold"
    })
    void testMembershipRank(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
        String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expectedResult, result);
    }
}
