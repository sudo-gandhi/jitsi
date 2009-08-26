package net.java.sip.communicator.plugin.otr;

import net.java.otr4j.OtrPolicy;
import net.java.otr4j.session.SessionStatus;
import net.java.sip.communicator.service.protocol.AccountID;
import net.java.sip.communicator.service.protocol.Contact;

public interface ScOtrEngine
{
    // Proxy methods OtrEngine.
    public abstract String transformSending(Contact contact, String content);

    public abstract String transformReceiving(Contact contact, String content);

    public abstract void startSession(Contact contact);

    public abstract void endSession(Contact contact);

    public abstract void refreshSession(Contact contact);

    public abstract SessionStatus getSessionStatus(Contact contact);

    // New Methods (Key Management)
    public abstract void generateKeyPair(String accountID);
    
    public abstract String getRemoteFingerprint(Contact contact);

    public abstract void verifyContactFingerprint(Contact contact);
    
    public abstract void forgetContactFingerprint(Contact contact);

    public abstract String getLocalFingerprint(AccountID account);
    
    public abstract boolean isContactVerified(Contact contact);

    // New Methods (Misc)
    public abstract boolean isMessageUIDInjected(String messageUID);

    public abstract void addListener(ScOtrEngineListener listener);

    public abstract void removeListener(ScOtrEngineListener listener);

    // New Methods (Policy management)
    public abstract OtrPolicy getGlobalPolicy();

    public abstract OtrPolicy getContactPolicy(Contact contact);

    public abstract void setGlobalPolicy(OtrPolicy policy);

    public abstract void setContactPolicy(Contact contact, OtrPolicy policy);

    public abstract void launchHelp();

}
