export type TransactionSetupType = {
  amountInCents: String;
  stoneCode?: String;
  pinpadMacAddress?: String;
  capture: Boolean;
  typeOfTransaction: 'DEBIT' | 'CREDIT' | 'VOUCHER' | 'INSTANT_PAYMENT' | 'PIX';
  entryMode?:
    | 'MAGNETIC_STRIPE'
    | 'CHIP_N_PIN'
    | 'CONTACTLESS'
    | 'CONTACTLESS_MAG'
    | 'QRCODE'
    | 'UNKNOWN';
  installmentCount?: Number;
  installmentHasInterest?: Boolean;
  initiatorTransactionKey?: String;
  shortName?: String;
  subMerchantCategoryCode?: String;
  subMerchantAddress?: String;
  subMerchantCity?: String;
  subMerchantPostalAddress?: String;
  subMerchantRegisteredIdentifier?: String;
  subMerchantTaxIdentificationNumber?: String;
  useDefaultUI?: Boolean;
  dialogTitle?: String;
  dialogMessage?: String;
};

export type InstalmentTransactionType = {
  count?: Number;
  interest?: Boolean;
  name?: String;
};

export type TransactionType = {
  amount: String;
  emailSent?: String;
  timeToPassTransaction?: String;
  initiatorTransactionKey?: String;
  acquirerTransactionKey?: String;
  cardHolderNumber?: String;
  cardHolderName?: String;
  date?: String;
  time?: String;
  aid?: String;
  arcq?: String;
  authorizationCode?: String;
  iccRelatedData?: String;
  transactionReference?: String;
  actionCode?: String;
  commandActionCode?: String;
  pinpadUsed?: String;
  saleAffiliationKey?: String;
  cne?: String;
  cvm?: String;
  balance?: String;
  serviceCode?: String;
  subMerchantCategoryCode?: String;
  entryMode?: String;
  cardBrandName?: String;
  instalmentTransaction?: InstalmentTransactionType;
  transactionStatus?:
    | 'UNKNOWN'
    | 'APPROVED'
    | 'DECLINED'
    | 'DECLINED_BY_CARD'
    | 'CANCELLED'
    | 'PARTIAL_APPROVED'
    | 'TECHNICAL_ERROR'
    | 'REJECTED'
    | 'WITH_ERROR'
    | 'PENDING_REVERSAL'
    | 'PENDING'
    | 'REVERSED';
  instalmentType?: String;
  typeOfTransactionEnum?: String;
  cancellationDate?: String;
  shortName?: String;
  subMerchantAddress?: String;
  //userModel?: UserModelType;
  cvv?: String;
  isFallbackTransaction?: Boolean;
  subMerchantCity?: String;
  subMerchantTaxIdentificationNumber?: String;
  subMerchantRegisteredIdentifier?: String;
  subMerchantPostalAddress?: String;
  appLabel?: String;
  //transAppSelectedInfo?: TransSelectedInfoType;
  cardExpireDate?: String;
  cardSequenceNumber?: String;
  externalId?: String;
  messageFromAuthorizer?: String;
};