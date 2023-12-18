export type TransactionSetupType = {
  amount: String;
  installmentCount?: String;
  amountOfEditable?: String;
  typeOfTransaction: 'DEBIT' | 'CREDIT' | 'VOUCHER' | 'INSTANT_PAYMENT' | 'PIX';
  typeOfInstallment?: 'MERCHANT' | 'ISSUER' | 'NONE';
};

export type TransactionType = {
  cardholder_name: String;
  itk?: String;
  atk?: String;
  authorization_date_time?: String;
  brand?: String;
  order_id?: String;
  authorization_code?: String;
  installment_count?: String;
  pan?: String;
  type?: String;
  entry_mode?: String;
  account_id?: String;
  customer_wallet_provider_id?: String;
  code?: String;
};

export type TransactionReprinter = {
  showw_feedback_screen?: String;
  type_customer?: String;
  atk?: String;
}