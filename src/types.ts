export type TransactionSetupType = {
  amount: String;
  installmentCount?: String;
  amountOfEditable?: String;
  typeOfTransaction: 'DEBIT' | 'CREDIT' | 'VOUCHER' | 'INSTANT_PAYMENT' | 'PIX';
  typeOfInstallment?: 'MERCHANT' | 'ISSUER' | 'NONE';
};

export type TransactionReprinter = {
  showw_feedback_screen?: String;
  type_customer?: String;
  atk?: String;
};

export type TransactionCancel = {
  editable_amount?: String;
  amount?: String;
  atk?: String;
};