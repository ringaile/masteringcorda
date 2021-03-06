package com.cordabook.complexstates.states;


import com.cordabook.complexstates.contracts.TemplateContract;
import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.LinearPointer;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@BelongsToContract(TemplateContract.class)
public class ChildViaLinearIDState implements LinearState {
    private final UniqueIdentifier parent;
    private final Party party;
    private final UniqueIdentifier linearId;

    public ChildViaLinearIDState(UniqueIdentifier parent, Party party) {
        this.parent = parent;
        this.party = party;
        this.linearId = new UniqueIdentifier();
    }


    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(party);
    }

    public UniqueIdentifier getParent() {
        return parent;
    }

    public Party getParty() {
        return party;
    }
}
