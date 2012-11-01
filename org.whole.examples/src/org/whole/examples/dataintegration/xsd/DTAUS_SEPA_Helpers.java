package org.whole.examples.dataintegration.xsd;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Interval;

public class DTAUS_SEPA_Helpers {
	static Map<Integer, String> bankIdToBICMap = new HashMap<Integer, String>();
	static Map<Integer, Map<Long, String>> accountNoWithBankIdToIBANMap = new HashMap<Integer, Map<Long, String>>();

	static {
		bankIdToBICMap.put(50099900, "GENODE51RGG");
		bankIdToBICMap.put(70099900, "GENODEF1DCA");

		Map<Long, String> bankAccounts = new HashMap<Long, String>();
		bankAccounts.put(1234567890L, "DE13500999001234567890");
		accountNoWithBankIdToIBANMap.put(50099900, bankAccounts);

		bankAccounts = new HashMap<Long, String>();
		bankAccounts.put(9876543210L, "DE28700999009876543210");
		accountNoWithBankIdToIBANMap.put(70099900, bankAccounts);
	}

	public static String generateMessageId() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.printf("MSG%015d", System.currentTimeMillis() & 0x00000000FFFFFFFF);
		return sw.toString();
	}
	public static String generateEndToEndId() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.printf("REF%08d", System.currentTimeMillis() & 0x0000000000FFFFFF);
		return sw.toString();
	}

	private static SimpleDateFormat shortFormat = new SimpleDateFormat("ddMMyy", Locale.GERMAN);
	private static SimpleDateFormat longFormat = new SimpleDateFormat("ddMMyyyy", Locale.GERMAN);
	public static DateTime fromShortDate(String date) {
		try {
			return new DateTime(shortFormat.parse(date), DateTimeZone.forID("CET"));
		} catch (ParseException e) {
			throw new IllegalArgumentException("illegal short date format");
		}
	}
	public static Interval fromLongDate(String date) {
		try {
			return new Interval(new DateTime(longFormat.parse(date), DateTimeZone.forID("CET")), Days.ONE);
		} catch (ParseException e) {
			throw new IllegalArgumentException("illegal short date format");
		}
	}
	public static BigDecimal toDecimal(long amount) {
		return new BigDecimal(amount).divide(new BigDecimal(100));//FIXME
	}
	public static long toLong(BigDecimal amount) {
		return amount.multiply(new BigDecimal(100)).longValue();//FIXME
	}
	public static String bankIdToBIC(int bankId) {
		return bankIdToBICMap.get(bankId);
	}
	public static String accountNoWithBankIdToIBAN(long accountNo, int bankId) {
		return accountNoWithBankIdToIBANMap.get(bankId).get(accountNo);
	}
}
