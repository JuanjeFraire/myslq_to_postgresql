package com.ehsaniara.multidatasource.utils.enums;

public enum ConnectionError {
    UNKNOWN, TIMEOUT, SCRAPPING_DETECTED, EOF, ERROR_503, ERROR_400,
    PKIX_FAILED, CONNECTION_RESET, CONNECTION_REFUSED,
    SOFTWARE_ABORT, ERROR_500, ERROR_301, ERROR_403, ERROR_409,
    ERROR_405, ERROR_502, IRRELEVANT, TUNNEL_CONNECTION_FAILED;
}
