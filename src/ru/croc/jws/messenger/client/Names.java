package ru.croc.jws.messenger.client;

import java.util.Random;

public final class Names {

	private static final Random rnd = new Random(System.currentTimeMillis());

	private static final String[] ROOTS = new String[] {
			"баб",
			"бав",
			"бег",
			"бед",
			"бел",
			"бер",
			"бес",
			"бит",
			"бор",
			"бок",
			"бук",
			"бык",
			"важ",
			"вал",
			"вар",
			"вед",
			"вест",
			"веж",
			"век",
			"век",
			"вен",
			"вен",
			"вер",
			"вес",
			"вет",
			"веч",
			"ви",
			"вод",
			"вод",
			"вед",
			"воз",
			"вор",
			"при",
			"вяз",
			"гад",
			"гас",
			"гр",
			"год",
			"гон",
			"гор",
			"губ",
			"дар",
			"дев",
			"дед",
			"дел",
			"ден",
			"дет",
			"дом",
			"доч",
			"дел",
			"дух",
			"зел",
			"зен",
			"зн",
			"зоб",
			"зод",
			"зуб",
			"коз",
			"кос",
			"кост",
			"лев",
			"леж",
			"лез",
			"лек",
			"лен",
			"леп",
			"лес",
			"лет",
			"лех",
			"лож",
			"мат",
			"мам",
			"мед",
			"мел",
			"мен",
			"мес",
			"мет",
			"мет",
			"мех",
			"мор",
			"мор",
			"мыс",
			"наг",
			"неб",
			"нов",
			"ног",
			"нож",
			"нор",
			"нос",
			"ноч",
			"пап",
			"пер",
			"пис",
			"пут",
			"рад",
			"раз",
			"ров",
			"ров",
			"рог",
			"род",
			"рок",
			"рос",
			"рот",
			"рук",
			"рух",
			"ряд",
			"сел",
			"сид",
			"сор",
			"суд",
			"теч",
			"тер",
			"ток",
			"хот",
	};

	private static final String[] PREFIXES = new String[] {
			"",
			"в",
			"во",
			"взо",
			"вы",
			"до",
			"за",
			"из",
			"изо",
			"к",
			"на",
			"над",
			"не",
			"недо",
			"о",
			"об",
			"обо",
			"от",
			"ото",
			"па",
			"пере",
			"по",
			"под",
			"подо",
			"пра",
			"пред",
			"предо",
			"про",
			"разо",
			"с",
			"со",
			"су",
			"у",
			"из",
			"раз",
	};

	private static final String[] SUFFIXES = new String[]{
			"",
			"ок",
			"ик",
			"а",
			"ка",
			"ушка",
			"я",
			"ша",
			"яша",
			"ич",
			"ов",
			"ова",
			"ач",
			"ун",
			"ак",
			"ник",
			"ля",
	};

	private Names() {
		throw new IllegalStateException();
	}

	public static String randomName() {
		return PREFIXES[rnd.nextInt(PREFIXES.length)]
				+ ROOTS[rnd.nextInt(ROOTS.length)]
				+ SUFFIXES[rnd.nextInt(SUFFIXES.length)];
	}
}
