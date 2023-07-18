package guru.learningjournal.kafka.examples;


import guru.learningjournal.kafka.examples.types.EntityIdentifier;
import guru.learningjournal.kafka.examples.types.Notification;
import guru.learningjournal.kafka.examples.types.PosInvoice;
import guru.learningjournal.kafka.examples.types.SystemIdentifier;


class Notifications {

    static Notification getNotificationFrom(PosInvoice invoice) {
        return new Notification()
            .withInvoiceNumber(invoice.getInvoiceNumber())
            .withCustomerCardNo(invoice.getCustomerCardNo())
            .withTotalAmount(invoice.getTotalAmount())
            .withEarnedLoyaltyPoints(invoice.getTotalAmount() * AppConfigs.LOYALTY_FACTOR)
            .withTotalLoyaltyPoints(invoice.getTotalAmount() * AppConfigs.LOYALTY_FACTOR);
    }

    static EntityIdentifier getEntityIdentifierFrom(SystemIdentifier sysIdent) {
        return new EntityIdentifier()
                .addIdentifiers(sysIdent.getSourceSystem(), sysIdent.getSystemId())
                .withEntityId(sysIdent.getSingleUniquePartyId());
    }


}
