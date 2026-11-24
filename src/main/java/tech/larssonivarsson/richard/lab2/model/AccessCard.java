package tech.larssonivarsson.richard.lab2.model;

import java.time.LocalDate;
import java.util.Objects;

public class AccessCard {
    private final String cardNumber;
    private final LocalDate issueDate;
    private final LocalDate expiryDate;

    public AccessCard(String cardNumber, LocalDate issueDate, LocalDate expiryDate) {
        this.cardNumber = Objects.requireNonNull(cardNumber, "cardNumber cannot be null");
        this.issueDate = Objects.requireNonNull(issueDate, "issueDate cannot be null");
        this.expiryDate = Objects.requireNonNull(expiryDate, "expiryDate cannot be null");
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return cardNumber + " (utfärdat: " + issueDate + ", giltigt t.o.m. " + expiryDate + ")";
    }
}
