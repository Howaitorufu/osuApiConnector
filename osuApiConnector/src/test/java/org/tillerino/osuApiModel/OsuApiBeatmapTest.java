package org.tillerino.osuApiModel;

import static org.tillerino.osuApiModel.Mods.*;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class OsuApiBeatmapTest {
	@Test
	public void testRegression() throws IOException {
		OsuApiBeatmap expected = new OsuApiBeatmap();

		expected.setBeatmapId(75); expected.setSetId(1); expected.setArtist("Kenji Ninuma"); expected.setTitle("DISCO PRINCE"); expected.setVersion("Normal"); expected.setCreator("peppy"); expected.setSource(""); expected.setApproved(1); expected.setApprovedDate(1191692791000l); expected.setLastUpdate(1191692791000l); expected.setBpm(119.999); expected.setStarDifficulty(2.2918); expected.setOverallDifficulty(6); expected.setCircleSize(4); expected.setApproachRate(6); expected.setHealthDrain(6); expected.setHitLength(108); expected.setTotalLength(141); expected.setMode(0);

		OsuApiBeatmap downloaded = new Downloader().getBeatmap(75, OsuApiBeatmap.class);

		assertEquals(expected, downloaded);
	}

	@Test
	public void testCalcOd() throws Exception {
		assertEquals(-6 - 2 / 3d, OsuApiBeatmap.calcOd(0, getMask(HalfTime, Easy)), 1E-15);
		assertEquals(-2 - 1 / 6d, OsuApiBeatmap.calcOd(6, getMask(HalfTime, Easy)), 1E-15);
		assertEquals(3 + 5 / 6d, OsuApiBeatmap.calcOd(7, getMask(HalfTime)), 1E-15);
		assertEquals(8 + 1 / 3d, OsuApiBeatmap.calcOd(10, getMask(HalfTime, HardRock)), 1E-15);
		assertEquals(5.777777777, OsuApiBeatmap.calcOd(4, getMask(DoubleTime, Easy)), 1E-6);
		assertEquals(9.777777777, OsuApiBeatmap.calcOd(8, getMask(DoubleTime)), 2E-6);
		assertEquals(10.44444444, OsuApiBeatmap.calcOd(9, getMask(DoubleTime)), 2E-6);
		assertEquals(11.111111111, OsuApiBeatmap.calcOd(10, getMask(DoubleTime, HardRock)), 1E-6);
	}

	@Test
	public void testMsToAr() {
		assertEquals(-7.5, OsuApiBeatmap.msToAr(2700), 1E-15);
		assertEquals(0, OsuApiBeatmap.msToAr(1800), 1E-15);
		assertEquals(2, OsuApiBeatmap.msToAr(1560), 1E-15);
		assertEquals(5, OsuApiBeatmap.msToAr(1200), 1E-15);
		assertEquals(7, OsuApiBeatmap.msToAr(900), 1E-15);
		assertEquals(10, OsuApiBeatmap.msToAr(450), 1E-15);
		assertEquals(11, OsuApiBeatmap.msToAr(300), 1E-15);
	}

	@Test
	public void testOdToMs() throws Exception {
		assertEquals(80, OsuApiBeatmap.odToMs(0), 1E-15);
		assertEquals(50, OsuApiBeatmap.odToMs(5), 1E-15);
		assertEquals(20, OsuApiBeatmap.odToMs(10), 1E-15);
		assertEquals(14, OsuApiBeatmap.odToMs(11), 1E-15);
		assertEquals(54, OsuApiBeatmap.odToMs(4 + 1 / 3d), 1E-15);
		assertEquals(87.5, OsuApiBeatmap.odToMs(-1.25), 1E-15);
		assertEquals(119, OsuApiBeatmap.odToMs(-6.5), 1E-15);
	}

	@Test
	public void testCalcAR() throws Exception {
		assertEquals(-5, OsuApiBeatmap.calcAR(0, getMask(HalfTime, Easy)), 1E-15);
		assertEquals(-1, OsuApiBeatmap.calcAR(6, getMask(HalfTime, Easy)), 1E-15);
		assertEquals(5, OsuApiBeatmap.calcAR(7, getMask(HalfTime)), 1E-15);
		assertEquals(9, OsuApiBeatmap.calcAR(10, getMask(HalfTime, HardRock)), 1E-15);
		assertEquals(6 + 2 / 30d, OsuApiBeatmap.calcAR(4, getMask(DoubleTime, Easy)), 1E-15);
		assertEquals(9 + 2 / 3d, OsuApiBeatmap.calcAR(8, getMask(DoubleTime)), 2E-15);
		assertEquals(10 + 1 / 3d, OsuApiBeatmap.calcAR(9, getMask(DoubleTime)), 2E-15);
		assertEquals(11, OsuApiBeatmap.calcAR(10, getMask(DoubleTime, HardRock)), 0);
	}

	@Test
	public void testArToMs() {
		assertEquals(2400, OsuApiBeatmap.arToMs(-5), 1E-15);
		assertEquals(1800, OsuApiBeatmap.arToMs(0), 1E-15);
		assertEquals(1560, OsuApiBeatmap.arToMs(2), 1E-15);
		assertEquals(1200, OsuApiBeatmap.arToMs(5), 1E-15);
		assertEquals(900, OsuApiBeatmap.arToMs(7), 1E-15);
		assertEquals(450, OsuApiBeatmap.arToMs(10), 1E-15);
		assertEquals(300, OsuApiBeatmap.arToMs(11), 1E-15);
	}

	@Test
	public void testMsToOd() throws Exception {
		assertEquals(0, OsuApiBeatmap.msToOd(80), 1E-15);
		assertEquals(5, OsuApiBeatmap.msToOd(50), 1E-15);
		assertEquals(10, OsuApiBeatmap.msToOd(20), 1E-15);
		assertEquals(11, OsuApiBeatmap.msToOd(14), 1E-15);
		assertEquals(4 + 1 / 3d, OsuApiBeatmap.msToOd(54), 1E-15);
		assertEquals(-1.25, OsuApiBeatmap.msToOd(87.5), 1E-15);
		assertEquals(-6.5, OsuApiBeatmap.msToOd(119), 1E-15);
	}
}
