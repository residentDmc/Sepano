package com.example.sampleapplication.utils.build_config


class BuildConfig {
    companion object {
        const val BASE_URL = "https://1833hamedan.ir/api/v1/"
        const val BASE_URL_IMAGE = "https://1833hamedan.ir/"
        const val BASE_URL_MAP_IR = "https://map.ir/"

        //api_open_street_map
        const val REVERS = "reverse"
        const val DISTANCE_MATRIX = "distancematrix"
        const val SEARCH = "search/v2"

        //api
        const val LOGIN = "login"
        const val REGISTER = "register"
        const val FORGET_PASSWORD = "forgot_password"
        const val PROVINCE = "user/provinces"
        const val CITY = "user/getCities/{id}"
        const val ACTIVATION_MOBILE = "driver/active_mobile"
        const val CHANGE_PASSWORD = "driver/change_password"
        const val PROFILE = "profile"
        const val CREDIT = "user/credit"
        const val PAY = "driver/pay"
        const val TRANSACTION_SEARCH = "user/transaction/search"
        const val MY_TRAVEL = "driver/travels/my"
        const val SHOW_TRAVEL = "driver/travel/show"
        const val ADDRESS = "driver/addresses"
        const val TRAVEL_COST = "driver/travel/cost"
        const val TRAVEL_REGISTER = "driver/travel/register"

        //filed
        const val API_TOKEN = "api_token"
        const val CODE = "code"
        const val ACTIVE_CODE = "active_code"
        const val NEW_PASSWORD = "new_password"
        const val AMOUNT = "amount"
        const val FROM_DATE = "from_date"
        const val TO_DATE = "to_date"

        //filed
        const val MOBILE = "mobile"
        const val USER_NAME = "username"
        const val PASSWORD = "password"

        //token

        const val TOKEN_SOCKET= "4eff19bb521f79cd12c877ef96672285"
        const val TOKEN_MAP = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2In0.eyJhdWQiOiIxMDkxNyIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2IiwiaWF0IjoxNjAwNjMyNTkxLCJuYmYiOjE2MDA2MzI1OTEsImV4cCI6MTYwMzIyNDU5MSwic3ViIjoiIiwic2NvcGVzIjpbImJhc2ljIl19.fd-kP-VYpy6vBbTMoSFo_GkuxvdTSHjthJftHZdGRDsH0kcOgYtso_g4ACD6QONUkiRQrndTZjFr-7cpBGIdxIibDh7J8DOaPBJEWF_r74MA-2A3_-BavsAALo313tVhljgR0fCW54_uGPHsiSELMlJq1TegFYH3BAQr4otv05tNLJ0AY_TeG6GRznuD7SDXmp5henZfen1zkliovfGBA-YtLcxacoc4V8-X7hZiK3Vk6vuWF56B7VEahi7E8YxieaO_ZkLJ4M0zD8TiwbMlXz_5LHYrzmHidp5wKarcPD4NXYJ4ZCu0_okxMdpfPgHPfOZYlsAoVd7BQz3jkH7EIw"
        var TOKEN_APP= ""

        //header
        const val X_API_KEY = "x-api-key"

        //query
        const val LAT = "lat"
        const val LON = "lon"
        const val TEXT = "text"
        const val FILTER = "filter"
        const val FILTER_DISTANCE = "type eq distance"
        const val ORIGINS = "origins"
        const val DESTINATIONS = "destinations"

        //query_defualt
        const val JSON_V2 = "jsonv2"


        // mapbox
        const val STYLE_MAP_BOX = "https://tile.snappmaps.ir/styles/snapp-style/style.json"
        const val ZOOM_MAP = 15.0
        const val DURATION_ANIMATION = 7000

        //path
        const val ID = "id"

        // validation
        const val START_PHONE_NUMBER_VALIDATION = "09"

        // table
        const val USER_ENTITY = "user_entity"

        // state
        const val STATE_ACCOUNT = "display_user_information"
        const val STATE_CHANGE_PASSWORD = "change_password"
        const val STATE_WALLET = "wallet"
        const val STATE_MY_PAYMENT = "my_payments"
        const val STATE_MY_ADDRESSES = "my_addresses"
        const val STATE_MY_TRAVELS = "my_travels"
        const val STATE_EXIT = "exit"

        //state
        const val FAIL = "fail"
        const val NEW = "new"


        // database
        const val USER_DATABASE = "user_database"

        //emit socket
        const val TAXI_CHANNEL = "08b72339-9926-4369-9c26-532ebcae4debtaxi-channel"
        const val SELECT_TRAVEL = ".select-travel"
        const val END_TRAVEL = ".end-travel"
        const val CANCEL_TRAVEL = ".cancel-travel"


        //request_code
        const val REQUEST_USER_CONSENT = 100
        const val REQUEST_LOCATION_PERMISSION = 200
        const val REQUEST_GOOGLE_SEARCH_PERMISSION = 300
        const val GPS_SETTINGS = 0x7

        //timer
        const val TIMER = 90000
        const val COUNT_DOWN_INTERNAL = 1000

        //date
        const val MIN_YEAR_DATE = 1400
        const val PERSIAN_DATE = 1400
        const val PERSIAN_MONT = 2
        const val PERSIAN_DAY = 17


        //state_marker
        const val STATE_ORIGIN = 1
        const val STATE_DISTANCE = 2
        const val STATE_DISTANCE_TWO = 3
        const val STATE_REQUEST_PAY = 4

        // state socket
        const val STATE_CONNECTING = 1
        const val STATE_CONNECTED = 2
        const val STATE_DISCONNECTED = 3

        // request_location
        const val INTERVAL = (1000 * 300).toLong()
        const val FASTEST_INTERVAL = (1000 * 200).toLong()

        const val DEFAULT_INTERVAL_IN_MILLISECONDS = 100L
        const val DEFAULT_MAX_WAIT_TIME = DEFAULT_INTERVAL_IN_MILLISECONDS * 5






    }
}