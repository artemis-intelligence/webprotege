package edu.stanford.bmir.protege.web.shared.match.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 11 Jun 2018
 */
@AutoValue
@GwtCompatible(serializable = true)
@JsonTypeName("StringEquals")
public abstract class StringEqualsCriteria implements SimpleStringMatchCriteria {

    @JsonCreator
    @Nonnull
    public static StringEqualsCriteria get(@Nonnull @JsonProperty(VALUE) String value,
                                           @JsonProperty(IGNORE_CASE) boolean ignoreCase) {
        return new AutoValue_StringEqualsCriteria(value, ignoreCase);
    }

    @Override
    public <R> R accept(@Nonnull LexicalValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }
}