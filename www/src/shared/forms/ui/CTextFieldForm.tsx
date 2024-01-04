import {TextField} from "@mui/material";
import {Control, Controller, ControllerProps, FieldPath, FieldValues} from "react-hook-form";
import {TextFieldProps} from "@mui/material/TextField/TextField";

interface ITextFieldFormProps<TFieldValues extends FieldValues = FieldValues, TName extends FieldPath<TFieldValues> = FieldPath<TFieldValues>, TContext = any>{
  name: string
  label: string
  control: Control<TFieldValues, TContext>
  variant?: TextFieldProps["variant"]
  rules?: ControllerProps<TFieldValues, TName>["rules"]
  textFieldProps?: TextFieldProps
  controllerProps?: ControllerProps<TFieldValues, TName>
}

const CTextFieldForm = ({ control, name, label, textFieldProps, controllerProps, rules, variant }: ITextFieldFormProps) => (
  <Controller
    render={({ field }) => (
      <TextField
        {...field}
        required={!!rules?.required}
        {...{
          ...textFieldProps,
          label,
          variant
        }}
      />
    )}
    {...{
      ...controllerProps,
      name,
      control,
      rules,
    }}
  />
)

export default CTextFieldForm
