package com.sportmonks.aggregate.core.data.parse;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MyModule extends SimpleModule {

    public MyModule() {
        super("My Module");
        System.out.println("MyModule constructor");
    }

    @Override
    public void setupModule(SetupContext setupContext) {
        super.setupModule(setupContext);
        System.out.println("Setup Module");
        SimpleDeserializers deserializers = new SimpleDeserializers();
//        deserializers.addDeserializer(League.class, new LeagueDeserializer());
        setupContext.addDeserializers(deserializers);
    }
}
