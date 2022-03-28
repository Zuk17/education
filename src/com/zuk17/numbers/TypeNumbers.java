package com.zuk17.numbers;

import java.util.HashSet;

public enum TypeNumbers {

    BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD;

    // Even and Odd, Duck and Spy, Sunny and Square, Sad and Happy
    public static HashSet<String> checkTypesInHashSet(HashSet<TypeNumbers> types, String prefix) {
        //check in each hashSet dOOM variants
        HashSet<String> wrongTypes = new HashSet<>();

        TypeNumbers[][] badArray = {
                {EVEN, ODD},
                {DUCK, SPY},
                {SUNNY, SQUARE},
                {SAD, HAPPY}
        };

        for (TypeNumbers[] typeNumbers : badArray)
            if (types.contains(typeNumbers[0]) && types.contains(typeNumbers[1])) {
                wrongTypes.add(prefix + typeNumbers[0].toString());
                wrongTypes.add(prefix + typeNumbers[1].toString());
            }
        return wrongTypes;
    }

    // [a, -a]
    public static HashSet<String> checkTypesFindAndDeny(HashSet<TypeNumbers> typesForFind,
                                                        HashSet<TypeNumbers> typesForDeny) {
        HashSet<String> wrongTypes = new HashSet<>();

        HashSet<TypeNumbers> tmp = new HashSet<>();
        tmp.addAll(typesForFind);

        wrongTypes.addAll(TypeNumbers.checkTypesInHashSet(typesForFind, ""));
        wrongTypes.addAll(TypeNumbers.checkTypesInHashSet(typesForDeny, "-"));

        for (TypeNumbers a : typesForDeny)
            if (!tmp.add(a)) {
                wrongTypes.add(a.name());
                wrongTypes.add("-" + a.name());
            }
        return wrongTypes;
    }
}