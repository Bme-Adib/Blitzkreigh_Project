package com.herculife.herculifeLunaEMG.ProjectSettings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CountryList {
    private final ObservableList<String> country;
    private final ObservableList<String> countries;

    public CountryList() {
        country = FXCollections.observableArrayList();
        countries = FXCollections.observableArrayList();
        initializeCountries();
    }

    private void initializeCountries() {
        countries.add("--,-- Select Nationality --,--");
        countries.add("MY,Malaysia,+60");
        countries.add("SY,Syria,+963");
        countries.add("AF,Afghanistan,+93");
        countries.add("AL,Albania,+355");
        countries.add("DZ,Algeria,+213");
        countries.add("AD,Andorra,+376");
        countries.add("AO,Angola,+244");
        countries.add("AG,Antigua and Barbuda,+1-268");
        countries.add("AR,Argentina,+54");
        countries.add("AM,Armenia,+374");
        countries.add("AU,Australia,+61");
        countries.add("AT,Austria,+43");
        countries.add("AZ,Azerbaijan,+994");
        countries.add("BS,Bahamas,+1-242");
        countries.add("BH,Bahrain,+973");
        countries.add("BD,Bangladesh,+880");
        countries.add("BB,Barbados,+1-246");
        countries.add("BY,Belarus,+375");
        countries.add("BE,Belgium,+32");
        countries.add("BZ,Belize,+501");
        countries.add("BJ,Benin,+229");
        countries.add("BT,Bhutan,+975");
        countries.add("BO,Bolivia,+591");
        countries.add("BA,Bosnia and Herzegovina,+387");
        countries.add("BW,Botswana,+267");
        countries.add("BR,Brazil,+55");
        countries.add("BN,Brunei Darussalam,+673");
        countries.add("BG,Bulgaria,+359");
        countries.add("BF,Burkina Faso,+226");
        countries.add("BI,Burundi,+257");
        countries.add("KH,Cambodia,+855");
        countries.add("CM,Cameroon,+237");
        countries.add("CA,Canada,+1");
        countries.add("CV,Cape Verde,+238");
        countries.add("CF,Central African Republic,+236");
        countries.add("TD,Chad,+235");
        countries.add("CL,Chile,+56");
        countries.add("CN,China,+86");
        countries.add("CO,Colombia,+57");
        countries.add("KM,Comoros,+269");
        countries.add("CG,Congo,+242");
        countries.add("CD,D.R. Congo,+243");
        countries.add("CR,Costa Rica,+506");
        countries.add("HR,Croatia,+385");
        countries.add("CU,Cuba,+53");
        countries.add("CY,Cyprus,+357");
        countries.add("CZ,Czech Republic,+420");
        countries.add("CI,Côte d'Ivoire,+225");
        countries.add("DK,Denmark,+45");
        countries.add("DJ,Djibouti,+253");
        countries.add("DM,Dominica,+1-767");
        countries.add("DO,Dominican Republic,+1-809, +1-829, +1-849");
        countries.add("EC,Ecuador,+593");
        countries.add("EG,Egypt,+20");
        countries.add("SV,El Salvador,+503");
        countries.add("GQ,Equatorial Guinea,+240");
        countries.add("ER,Eritrea,+291");
        countries.add("EE,Estonia,+372");
        countries.add("ET,Ethiopia,+251");
        countries.add("FK,Falkland Islands (Malvinas),+500");
        countries.add("FO,Faroe Islands,+298");
        countries.add("FJ,Fiji,+679");
        countries.add("FI,Finland,+358");
        countries.add("FR,France,+33");
        countries.add("GF,French Guiana,+594");
        countries.add("PF,French Polynesia,+689");
        countries.add("GA,Gabon,+241");
        countries.add("GM,Gambia,+220");
        countries.add("GE,Georgia,+995");
        countries.add("DE,Germany,+49");
        countries.add("GH,Ghana,+233");
        countries.add("GI,Gibraltar,+350");
        countries.add("GR,Greece,+30");
        countries.add("GL,Greenland,+299");
        countries.add("GD,Grenada,+1-473");
        countries.add("GP,Guadeloupe,+590");
        countries.add("GU,Guam,+1-671");
        countries.add("GT,Guatemala,+502");
        countries.add("GN,Guinea,+224");
        countries.add("GW,Guinea-Bissau,+245");
        countries.add("GY,Guyana,+592");
        countries.add("HT,Haiti,+509");
        countries.add("HN,Honduras,+504");
        countries.add("HK,Hong Kong,+852");
        countries.add("HU,Hungary,+36");
        countries.add("IS,Iceland,+354");
        countries.add("IN,India,+91");
        countries.add("ID,Indonesia,+62");
        countries.add("IR,Iran,+98");
        countries.add("IQ,Iraq,+964");
        countries.add("IE,Ireland,+353");
        countries.add("IT,Italy,+39");
        countries.add("JM,Jamaica,+1-876");
        countries.add("JP,Japan,+81");
        countries.add("JO,Jordan,+962");
        countries.add("KZ,Kazakhstan,+7");
        countries.add("KE,Kenya,+254");
        countries.add("KI,Kiribati,+686");
        countries.add("KP,North Korea,+850");
        countries.add("KR,South Korea,+82");
        countries.add("KW,Kuwait,+965");
        countries.add("KG,Kyrgyzstan,+996");
        countries.add("LA,Laos,+856");
        countries.add("LV,Latvia,+371");
        countries.add("LB,Lebanon,+961");
        countries.add("LS,Lesotho,+266");
        countries.add("LR,Liberia,+231");
        countries.add("LY,Libya,+218");
        countries.add("LI,Liechtenstein,+423");
        countries.add("LT,Lithuania,+370");
        countries.add("LU,Luxembourg,+352");
        countries.add("MO,Macau,+853");
        countries.add("MK,North Macedonia,+389");
        countries.add("MG,Madagascar,+261");
        countries.add("MW,Malawi,+265");
        countries.add("MV,Maldives,+960");
        countries.add("ML,Mali,+223");
        countries.add("MT,Malta,+356");
        countries.add("MH,Marshall Islands,+692");
        countries.add("MQ,Martinique,+596");
        countries.add("MR,Mauritania,+222");
        countries.add("MU,Mauritius,+230");
        countries.add("YT,Mayotte,+262");
        countries.add("MX,Mexico,+52");
        countries.add("FM,Micronesia,+691");
        countries.add("MD,Moldova,+373");
        countries.add("MC,Monaco,+377");
        countries.add("MN,Mongolia,+976");
        countries.add("ME,Montenegro,+382");
        countries.add("MS,Montserrat,+1-664");
        countries.add("MA,Morocco,+212");
        countries.add("MZ,Mozambique,+258");
        countries.add("MM,Myanmar,+95");
        countries.add("NA,Namibia,+264");
        countries.add("NR,Nauru,+674");
        countries.add("NP,Nepal,+977");
        countries.add("NL,Netherlands,+31");
        countries.add("NC,New Caledonia,+687");
        countries.add("NZ,New Zealand,+64");
        countries.add("NI,Nicaragua,+505");
        countries.add("NE,Niger,+227");
        countries.add("NG,Nigeria,+234");
        countries.add("NU,Niue,+683");
        countries.add("NF,Norfolk Island,+672");
        countries.add("MP,Northern Mariana Islands,+1-670");
        countries.add("NO,Norway,+47");
        countries.add("OM,Oman,+968");
        countries.add("PK,Pakistan,+92");
        countries.add("PW,Palau,+680");
        countries.add("PS,Palestine,+970");
        countries.add("PA,Panama,+507");
        countries.add("PG,Papua New Guinea,+675");
        countries.add("PY,Paraguay,+595");
        countries.add("PE,Peru,+51");
        countries.add("PH,Philippines,+63");
        countries.add("PL,Poland,+48");
        countries.add("PT,Portugal,+351");
        countries.add("PR,Puerto Rico,+1-787, +1-939");
        countries.add("QA,Qatar,+974");
        countries.add("RE,Réunion,+262");
        countries.add("RO,Romania,+40");
        countries.add("RU,Russia,+7");
        countries.add("RW,Rwanda,+250");
        countries.add("BL,Saint Barthélemy,+590");
        countries.add("SH,Saint Helena,+290");
        countries.add("KN,Saint Kitts and Nevis,+1-869");
        countries.add("LC,Saint Lucia,+1-758");
        countries.add("MF,Saint Martin,+590");
        countries.add("PM,Saint Pierre and Miquelon,+508");
        countries.add("VC,Saint Vincent and the Grenadines,+1-784");
        countries.add("WS,Samoa,+685");
        countries.add("SM,San Marino,+378");
        countries.add("ST,Sao Tome and Principe,+239");
        countries.add("SA,Saudi Arabia,+966");
        countries.add("SN,Senegal,+221");
        countries.add("RS,Serbia,+381");
        countries.add("SC,Seychelles,+248");
        countries.add("SL,Sierra Leone,+232");
        countries.add("SG,Singapore,+65");
        countries.add("SX,Sint Maarten,+1-721");
        countries.add("SK,Slovakia,+421");
        countries.add("SI,Slovenia,+386");
        countries.add("SB,Solomon Islands,+677");
        countries.add("SO,Somalia,+252");
        countries.add("ZA,South Africa,+27");
        countries.add("SS,South Sudan,+211");
        countries.add("ES,Spain,+34");
        countries.add("LK,Sri Lanka,+94");
        countries.add("SD,Sudan,+249");
        countries.add("SR,Suriname,+597");
        countries.add("SJ,Svalbard and Jan Mayen,+47");
        countries.add("SZ,Swaziland,+268");
        countries.add("SE,Sweden,+46");
        countries.add("CH,Switzerland,+41");
        countries.add("TW,Taiwan,+886");
        countries.add("TJ,Tajikistan,+992");
        countries.add("TZ,Tanzania,+255");
        countries.add("TH,Thailand,+66");
        countries.add("TL,Timor-Leste,+670");
        countries.add("TG,Togo,+228");
        countries.add("TK,Tokelau,+690");
        countries.add("TO,Tonga,+676");
        countries.add("TT,Trinidad and Tobago,+1-868");
        countries.add("TN,Tunisia,+216");
        countries.add("TR,Turkey,+90");
        countries.add("TM,Turkmenistan,+993");
        countries.add("TC,Turks and Caicos Islands,+1-649");
        countries.add("TV,Tuvalu,+688");
        countries.add("UG,Uganda,+256");
        countries.add("UA,Ukraine,+380");
        countries.add("AE,United Arab Emirates,+971");
        countries.add("GB,United Kingdom,+44");
        countries.add("US,United States,+1");
        countries.add("UY,Uruguay,+598");
        countries.add("UZ,Uzbekistan,+998");
        countries.add("VU,Vanuatu,+678");
        countries.add("VA,Vatican City,+379");
        countries.add("VE,Venezuela,+58");
        countries.add("VN,Vietnam,+84");
        countries.add("VG,Virgin Islands (British),+1-284");
        countries.add("VI,Virgin Islands (U.S.),+1-340");
        countries.add("WF,Wallis and Futuna,+681");
        countries.add("YE,Yemen,+967");
        countries.add("ZM,Zambia,+260");
        countries.add("ZW,Zimbabwe,+263");
    }


    public ObservableList<String> getCountries() {
//        return countries;
        ObservableList<String> co = FXCollections.observableArrayList();
        for (String c : this.countries) {
            String[] parts = c.split(",");
            co.add(parts[1]);
        }
        return co;
    }

    public void printAll() {
        // Print the list of countries and their abbreviations
        for (String country : countries) {
            String[] parts = country.split(",");
            String abb = parts[0];
            String name = parts[1];
            String code = parts[2];
            System.out.println("Country: " + name + ", Abbreviation: " + abb + ", Dialing Code: " + code);
        }
    }

    public String getAbb(String country) {
        String abb = "00";

        for (String c : this.countries) {
            String[] parts = c.split(",");
            if (parts[1].equalsIgnoreCase(country)) {
                abb = parts[0];
            }
        }
        return abb;
    }

    public String getCountryCode(String country) {
        String code = "+00";

        for (String c : this.countries) {
            String[] parts = c.split(",");
            if (parts[1].equalsIgnoreCase(country)) {
                code = parts[2];
            }
        }
        return code;
    }

    public ObservableList<String> getCountriesCode() {
        ObservableList<String> cc = FXCollections.observableArrayList();
        for (String c : this.countries) {
            String[] parts = c.split(",");
            cc.add(parts[2]);
        }
        return cc;
    }
}