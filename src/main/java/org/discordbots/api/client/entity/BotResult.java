package org.discordbots.api.client.entity;

// This class is needed because of the way Java generics work. I can't reference Result<Bot> as a class
// so this is just a simple workaround for that
public class BotResult extends Result<Bot> {}
