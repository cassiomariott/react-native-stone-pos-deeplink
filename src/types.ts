export type TransactionSetupType = {
  amount?: String;
  return_scheme?: string;
  installmentCount?: String;
  amountOfEditable?: String;
  typeOfTransaction: 'DEBIT' | 'CREDIT' | 'VOUCHER' | 'INSTANT_PAYMENT' | 'PIX';
  typeOfInstallment?: 'MERCHANT' | 'ISSUER' | 'NONE';
};

export type TransactionReprinter = {
  show_feedback_screen?: String;
  return_scheme?: string;
  type_customer?: String;
  atk?: String;
};

export type TransactionCancel = {
  editable_amount?: String;
  return_scheme?: string;
  amount?: String;
  atk?: String;
};

export type PrinterType = {
  show_feedback_screen?: String;
  return_scheme?: string;
  json?: String;
};